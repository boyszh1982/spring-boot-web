package com.nameless.mapper.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
/**
 * 这是类可以在rs.get rs.set 方法前后做一些事情
 * <result column="product_name" 
 * property="productName" jdbcType="VARCHAR" 
 * typeHandler="com.nameless.mapper.typehandler.ImportMarkTypeHandler"/>
  
 * @author Administrator
 *
 * @param <E>
 */
public class ImportMarkTypeHandler<E> extends BaseTypeHandler<E> {

	private Class<E> type;
	
	public ImportMarkTypeHandler(Class<E> type){
		this.type = type;
		System.out.println("ImportMarkTypeHandler..."+type);
	}
	
	@Override
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return (E) ("["+rs.getObject(columnName)+"]1");
	}

	@Override
	public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return (E) ("["+rs.getObject(columnIndex)+"]2");
	}

	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		return (E) cs.getObject(columnIndex);
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int parameterIndex, E parameter,
			JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		ps.setObject(parameterIndex, parameter);
	}

}
