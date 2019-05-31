package club.apibank.smartengines.controllers;

import club.apibank.connectors.smartengines.model.AttachmentType;
import club.apibank.connectors.smartengines.service.Recognition;
import club.apibank.smartengines.services.InputStreamExample;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/rest")
public class SerialCheck {


	Recognition recognition = new Recognition();

	@GetMapping("/rest")
	public String newRequest() {



		try {
			InputStreamExample inputStreamExample = new InputStreamExample();
			return recognition.createRecognition2(AttachmentType.PASSPORT_SCAN, inputStreamExample.get());
		} catch (IOException e) {
			e.printStackTrace();
			return "null";
		}

	}
}
