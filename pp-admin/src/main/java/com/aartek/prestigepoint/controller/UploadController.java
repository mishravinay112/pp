package com.aartek.prestigepoint.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aartek.prestigepoint.model.Upload;
import com.aartek.prestigepoint.service.UploadService;
import com.aartek.prestigepoint.util.IConstant;

@Controller
public class UploadController {

	private static final Logger logger = Logger.getLogger(UploadController.class);

	@Autowired
	private UploadService uploadService;

	@Value("${pp.uploadJar}")
	private String uploadJar;

	@RequestMapping("/upload")
	public String showUploadPage(Map<String, Object> map, Model model,
			@RequestParam(required = false) String uploadMessage) {
		model.addAttribute("uploadMessage", uploadMessage);
		return "upload";
	}

	@RequestMapping(value = "/Uploadjar", method = RequestMethod.POST)
	public String handleFileUpload(Model model, @RequestParam("type") String type,
			@RequestParam("file") MultipartFile file, HttpServletResponse response, Upload upload) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		// Create path components to save the file
		final String path = uploadJar + type;
		final MultipartFile filePart = file;
		final String fileName = file.getOriginalFilename();
		OutputStream out = null;
		InputStream filecontent = null;
		try {
			out = new FileOutputStream(new File(path + File.separator + fileName));
			filecontent = filePart.getInputStream();
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			model.addAttribute("uploadMessage", "New jar " + fileName + " is uploaded");
			upload.setJarType(type);
			upload.setNameOfJar(fileName);
			upload.setPathOfJar(path + File.separator + fileName);
			uploadService.uploadJar(upload);
		} catch (FileNotFoundException fne) {
			logger.info("FileNotFoundException!" + fne);
			model.addAttribute("uploadMessage", IConstant.JAR_FAILURE_MESSAGE);
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return "redirect:/upload.do";
	}
}
