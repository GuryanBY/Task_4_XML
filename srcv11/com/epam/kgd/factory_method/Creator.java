package com.epam.kgd.factory_method;

import com.epam.kgd.bean.Treasure;


public abstract class Creator {
	public abstract Treasure createTreasure(String type);

}
