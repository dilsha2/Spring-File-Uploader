package lk.ijse.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/upload")
@CrossOrigin
@ResponseBody
public class MainFormController {

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   Model model) {

        try {
            byte[] bytes = file.getBytes();
            model.addAttribute("image", Base64.getEncoder().encodeToString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "image-view";
    }
}

