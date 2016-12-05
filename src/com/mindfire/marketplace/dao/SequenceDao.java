package com.mindfire.marketplace.dao;

public interface SequenceDao {
	
	int getProductSequence(); 
	int getCategorySequence();
	int getProductMediaSequence();
	int getC2PRelationSequence();
	int getTempImageSequence();

}
