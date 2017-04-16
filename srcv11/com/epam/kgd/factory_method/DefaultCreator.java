package com.epam.kgd.factory_method;

import com.epam.kgd.bean.AncientBook;
import com.epam.kgd.bean.AncientScroll;
import com.epam.kgd.bean.Treasure;

public class DefaultCreator extends Creator {

	@Override
	public Treasure createTreasure(String type) {
		Treasure treasure = null;
		if(type.equals("ancient_book")){
			treasure = new AncientBook();
		}
		if(type.equals("ancient_scroll")){
			treasure = new AncientScroll();
		} 
		
		// another subclasses
		
		return treasure;
	}

}/*
 * if (qName.equals("ancient_book")) { treasure = new AncientBook();
 * treasure.setId(Integer.parseInt(attributes.getValue("id")));
 * 
 * } if (qName.equals("ancient_scroll")) { treasure = new
 * AncientScroll();
 * treasure.setId(Integer.parseInt(attributes.getValue("id")));
 * 
 * }
 */
