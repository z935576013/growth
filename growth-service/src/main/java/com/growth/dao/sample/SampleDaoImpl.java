package com.growth.dao.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growth.common.dal.DalClient;
import com.growth.common.file.FileClient;
import com.growth.dao.intf.sample.SampleDAO;
import com.growth.service.intf.sample.dto.Sample;

@Service
public class SampleDaoImpl implements SampleDAO {

	@Autowired
	DalClient dalClient;
	
	@Autowired
	FileClient fileClient;

	@Override
	public List<Sample> getList(Long startIndex, Integer num) {
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


}
