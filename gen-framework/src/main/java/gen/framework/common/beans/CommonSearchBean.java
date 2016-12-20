package gen.framework.common.beans;

/**
 * 自定义查询
 * @author gen
 *
 */
public class CommonSearchBean extends CommonBean {
	public CommonSearchBean() {
		// TODO Auto-generated constructor stub
		super();
	}
	/**
	 * 
	 * @param tablename 表名 (必须)
	 * @param ordername 排序字段
	 * @param custom 自定义返回字段
	 * @param condition 主表查询条件
	 * @param childConditions 从表查询条件
	 */
	public CommonSearchBean(String tablename ,String ordername, String custom, Object condition,
			CommonChildBean ... childConditions) {
		super(tablename, ordername, custom, condition, childConditions);

	}
}
