package club.apibank.moedelo.services;

import club.apibank.smartengines.model.DocType;
import club.apibank.smartengines.model.RecognitionResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import club.apibank.smartengines.SmartIDReader;
import java.io.IOException;
import org.gpbd.fl.domain.AttachmentType;
import org.gpbd.fl.domain.BusinessError;
import org.gpbd.fl.domain.BusinessException;
import java.util.UUID;

public class Recognition {

	private final ObjectMapper json = new ObjectMapper();

	public void createRecognition(AttachmentType scanType) throws IOException, BusinessException {
		if (!SmartIDReader.isSupported()) {
			throw new BusinessException(BusinessError.SC001, "Распознавание документов не поддерживается");
		}

		// Шаг 1. Система проверяет, что указанный партнер не находится в списке заблокированных. В противном
		// случае Система возвращает сообщение об ошибке и прекращает выполнение сценария.

		// Шаг 2. Система сохраняет полученный файл в файлохранилище.
		final UUID id = UUID.randomUUID();

		// Шаг 3. Система распознает полученный файл.
		InputStreamExample inputStreamExample = new InputStreamExample();

		final String recognitionResult = makeRecognitionResult(scanType, inputStreamExample.get());

		// Шаг 4. Система создает запись в журнале распознаваний в БД. Система сохраняет ИД распознавания,
		// полный путь до файла. ключ партнера.
		org.gpbd.fl.domain.entities.Recognition entity = new org.gpbd.fl.domain.entities.Recognition();
		entity.setId(id);
		entity.setScanType(scanType);
		entity.setResult(recognitionResult);
	}


	private String makeRecognitionResult(AttachmentType scanType, byte[] fileInfo) throws IOException {

		final byte[] imageData = fileInfo;
		final DocType docType = getDocType(scanType);
		final SmartIDReader reader = new SmartIDReader();
		final RecognitionResult recognitionResult = reader.processImage(imageData, docType);

		System.out.println(recognitionResult.toTraceString());

		return json.writeValueAsString(recognitionResult);
	}


	private DocType getDocType(AttachmentType attachmentType) {
		switch (attachmentType) {
			case PASSPORT_SCAN:
				return DocType.RusPassportNational;
			case SNILS_SCAN:
				return DocType.RusSnils;
			case INN_SCAN:
				return DocType.RusInn;
			default:
				throw new IllegalArgumentException(String.format("Unknown AttachmentType value: %s", attachmentType.name()));
		}
	}
}
