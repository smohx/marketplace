package com.mindfire.marketplace.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mindfire.marketplace.dao.SequenceDao;

public class DefaultSequenceDao implements SequenceDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	@Override
	public int getProductSequence() {
		String insertSql="insert into productsequence values(0)";
		String fetchSql="SELECT Auto_increment FROM information_schema.tables WHERE table_name='productsequence'";
		jdbcTemplate.execute(insertSql);
		return jdbcTemplate.queryForInt(fetchSql);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getCategorySequence() {

		String insertSql="insert into categorysequence values(0)";
		String fetchSql="SELECT Auto_increment FROM information_schema.tables WHERE table_name='categorysequence'";
		jdbcTemplate.execute(insertSql);
		return jdbcTemplate.queryForInt(fetchSql);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getProductMediaSequence() {
		String insertSql="insert into productmediasequence values(0)";
		String fetchSql="SELECT Auto_increment FROM information_schema.tables WHERE table_name='productmediasequence'";
		jdbcTemplate.execute(insertSql);
		return jdbcTemplate.queryForInt(fetchSql);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getC2PRelationSequence() {
		String insertSql="insert into c2prelationsequence values(0)";
		String fetchSql="SELECT Auto_increment FROM information_schema.tables WHERE table_name='c2prelationsequence'";
		jdbcTemplate.execute(insertSql);
		return jdbcTemplate.queryForInt(fetchSql);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getTempImageSequence() {

		String insertSql="insert into tempimagesequence values(0)";
		String fetchSql="SELECT Auto_increment FROM information_schema.tables WHERE table_name='tempimagesequence'";
		jdbcTemplate.execute(insertSql);
		return jdbcTemplate.queryForInt(fetchSql);
	}

}
