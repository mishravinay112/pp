/*package com.aartek.prestigepoint.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.mail.MultipartDataSource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aartek.prestigepoint.model.UploadBanner;
import com.aartek.prestigepoint.service.UploadBannerService;
import com.aartek.prestigepoint.util.IConstant;

@Controller
public class UploadBannerController {

	@Autowired
	private UploadBannerService uploadBannerService;

	@Value("${pp.uploadBImage}")
	private String uploadBImage;

	@RequestMapping("/uploadBanner")
	public String showUploadPage(Map<String, Object> map, Model model,
			@RequestParam(required = false) String uploadMessage) {
		model.addAttribute("uploadMessage", uploadMessage);
		return "uploadBanner";
	}

	@RequestMapping(value = "/uploadBImage", method = RequestMethod.POST)
	public String handleFileUpload(Model model,
			@RequestParam("type") String type,
			@RequestParam("image") MultipartDataSource image,
			HttpServletResponse response, UploadBanner uploadBanner)
			throws IOException {
		System.out.println("higjdsfhldsglkdshfkrsjfgregurleougoooorewgolrewugoirpew");
		response.setContentType("text/html;charset=UTF-8");
		// Create path components to save the file
		final String path = uploadBImage + type;
		final MultipartDataSource imagePart = image;
		final String imageName = ((MultipartFile) image).getOriginalFilename();
		OutputStream out = null;
		InputStream imagecontent = null;
		try {
			out = new FileOutputStream(new File(path + image + imageName));
			imagecontent = imagePart.getInputStream();
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = imagecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			model.addAttribute("uploadMessage", "New image " + imageName
					+ " is uploaded");
			uploadBanner.setImageType(type);
			uploadBanner.setNameOfImage(imageName);
			uploadBanner.setPathOfImage(path + image + imageName);
			uploadBannerService.uploadBImage(uploadBanner);
		} catch (FileNotFoundException fne) {
			model.addAttribute("uploadMessage", IConstant.JAR_FAILURE_MESSAGE);
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return "redirect:/uploadBanner.do";
	}

}
*/