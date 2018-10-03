package annotation;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.activation.FileDataSource;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;



/**
 * Excel导出
 * 
 * 
 * 
 */
public class ExcelUtils<E> {
	private E e;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int etimes = 0;

	public ExcelUtils(E e1){
		this.e = e1;
	}

	@SuppressWarnings("unchecked")
	public E get() throws InstantiationException,IllegalAccessException {
		return (E) e.getClass().newInstance();
	}
	
	/**
     * 将数据写入到Excel文件
     * 
     * @param filePath
     *            文件路径
     * @param sheetName
     *            工作表名称
     * @param title
     *            工作表标题栏
     * @param data
     *            工作表数据
     * @throws FileNotFoundException
     *             文件不存在异常
     * @throws IOException
     *             IO异常
     
	 * @param <T>*/
	public static <T> void writeToFiles(List<T> list,ExcelDataFormatter edf,String filePath){
		Workbook wb = getWorkbook(list,edf);
		FileOutputStream outputStream =null;
		try {
			outputStream = new FileOutputStream(filePath);
			wb.write(outputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(outputStream!=null){
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	private static <T> Workbook getWorkbook(List<T> list,ExcelDataFormatter edf){
		// 创建工作簿
		Workbook wb = new SXSSFWorkbook();
		
		if(list ==null|| list.size()==0){
			return wb;
		}
		
		Sheet sheet =wb.createSheet();
		Row row=sheet.createRow(0);
		Cell cell = null;

		CreationHelper creationHelper = wb.getCreationHelper();
		
		XSSFCellStyle titileStyle = (XSSFCellStyle)wb.createCellStyle();
		titileStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		XSSFColor color = new XSSFColor(new Color(159,213,183),null); 
		titileStyle.setFillForegroundColor(color);
		titileStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		
		Font font = wb.createFont();
		font.setColor(Font.COLOR_RED);
		font.setBold(true);
		
		
		
		titileStyle.setFont(font);
		
		Field [] fields = ReflectUtils.getAllField(list.get(0).getClass());
		Excel excel;
		int columnIndex = 0;
		for (Field field : fields) {
			field.setAccessible(true);
			excel=field.getAnnotation(Excel.class);
			if(excel==null||excel.skip()==true){
				continue;
			}
			
			sheet.setColumnWidth(columnIndex,excel.width()*256);
			
			cell = row.createCell(columnIndex);
			cell.setCellStyle(titileStyle);
			cell.setCellValue(excel.name());
			columnIndex++;
		}
		
		int rowIndex = 1;
		CellStyle cs=wb.createCellStyle();
		for (T t : list) {
			row = sheet.createRow(rowIndex);
			columnIndex = 0;
			Object object = null;
			for (Field field : fields) {
				field.setAccessible(true);
				excel=field.getAnnotation(Excel.class);
				if(excel==null|| excel.skip()==true){
					continue;
				}
				
				cell = row.createCell(columnIndex);
				try {
					object = field.get(t);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(object ==null){
					continue;
				}
				
				//处理日期
				if(object instanceof Date){
					cs.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
					cell.setCellStyle(cs);
					cell.setCellValue((Date)object);
				}else if (object instanceof Double || object instanceof Float) {
					cell.setCellValue((Double)object);
				}else if (object instanceof Boolean) {
					Boolean bool = (Boolean)object;
					if(edf==null){
						cell.setCellValue(bool);
					}else {
						Map<String,String > map = edf.get(field.getName());
						if(map==null){
							cell.setCellValue(bool);
						}else {
							cell.setCellValue(map.get(bool.toString().toLowerCase()));
						}
					}
				}else if (object instanceof Integer) {
					Integer intValue = (Integer)object;
					if(edf==null){
						cell.setCellValue(intValue);
					}else {
						Map<String,String> map = edf.get(field.getName());
						if(map==null){
							cell.setCellValue(intValue);
						}else {
							cell.setCellValue(map.get(intValue.toString()));
						}
					}
				}else {
					cell.setCellValue(object.toString());
				}
				
				columnIndex ++;
			}
			rowIndex++;
		}
		return wb;
	}
}


