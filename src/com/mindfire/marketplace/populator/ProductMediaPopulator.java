package com.mindfire.marketplace.populator;

import java.util.List;
import com.mindfire.marketplace.data.ProductMediaData;
import com.mindfire.marketplace.model.ProductMediaModel;

public class ProductMediaPopulator {
	public void populate(ProductMediaModel source,ProductMediaData target){
		if(null != source){
			target.setMediaURL(source.getMediaURL());
			target.setMediaCode(source.getMediaCode());
			target.setMediaType(source.getMediaType());
			target.setProductCode(source.getProductCode());
		}
	}
	public void populate(List<ProductMediaModel> sourceList,List<ProductMediaData> targetList){

		if(!sourceList.isEmpty()){
			for(ProductMediaModel source:sourceList){
				ProductMediaData target = new ProductMediaData();
				target.setMediaURL(source.getMediaURL());
				target.setMediaCode(source.getMediaCode());
				target.setMediaType(source.getMediaType());
				target.setProductCode(source.getProductCode());
				targetList.add(target);
			}
		}
	}

}
