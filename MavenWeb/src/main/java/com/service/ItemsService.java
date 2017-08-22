package com.service;

import java.util.List;

import com.po.Items;

public interface ItemsService {
	public List<Items> list()throws Exception;
	public Items selectItem(Integer id) throws Exception;
	public void updateItem(Items record) throws Exception;
	public List<Items> selectItemByIds(List<Integer> ids) throws Exception;
}
