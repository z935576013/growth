package com.growth.service.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.growth.common.dal.DalClient;
import com.growth.common.file.FileClient;
import com.growth.service.intf.sample.SampleService;
import com.growth.service.intf.sample.dto.Sample;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	DalClient dalClient;
	
	@Autowired
	FileClient fileClient;

	@Override
	public List<Sample> getList(Long startIndex, Long num) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("startIndex", startIndex);
//		map.put("maxCount", num);
//		return dalClient.queryForList("SAMPLE.SELECT_BY_FIELDS", map,
//				Sample.class);
		
		List<Sample> list=new ArrayList<Sample>();
		Sample sample=new Sample();
		sample.setId(1L);
		sample.setName("hehe");
		
		Sample sample2=new Sample();
		sample2.setId(1L);
		sample2.setName("hehe2");
		list.add(sample);
		list.add(sample2);
		return list;
	}

	@Override
	public void save(Sample sample) {
		dalClient.persist(sample);
	}

	@Override
	public String saveFile(MultipartFile file) {
		String path = null;
		try {
			File tempFile = File.createTempFile("qxicc", ".jpg");
			file.transferTo(tempFile);
			path = fileClient.saveFile(tempFile.getAbsolutePath(),
					FileClient.BIZTYPE_GAME,"bdfasfa发的发生的发生111");
			tempFile.delete();
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return null;
		}
		return fileClient.getFullPath(path);
	}

}
