package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.ItemsMapper;
import com.po.Items;
import com.po.ItemsExample;
@Service
public class ItemsServiceImpl implements ItemsService{
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> list() throws Exception {
		// TODO Auto-generated method stub
		ItemsExample example=new ItemsExample();
		List<Items> list= itemsMapper.selectByExampleWithBLOBs(example);
		return list;
		
	}

	@Override
	public Items selectItem(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Items item=itemsMapper.selectByPrimaryKey(id);
		return item;
	}

	@Override
	public void updateItem(Items record) throws Exception {
		// TODO Auto-generated method stub
		
		itemsMapper.updateByPrimaryKeyWithBLOBs(record);
		
	}

	@Override
	public List<Items> selectItemByIds(List<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		ItemsExample example=new ItemsExample();
		example.createCriteria().andIdIn(ids);
		List<Items> items=itemsMapper.selectByExampleWithBLOBs(example);
		return items;
	}


	

}
