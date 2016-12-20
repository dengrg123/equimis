package gen.framework.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import gen.framework.common.beans.CommonCountBean;
import gen.framework.common.beans.CommonPageBean;
import gen.framework.common.beans.CommonSearchBean;
@SuppressWarnings("rawtypes")
@Mapper
public interface CommonMapper {
	List selectForPage(CommonPageBean commonPageBean);
	long selectCount(CommonCountBean commonCountBean);
	List selectObjects(CommonSearchBean commonSearchBean);
}
