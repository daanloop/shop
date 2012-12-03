package net.malta.beans;
import org.apache.struts.upload.FormFile;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
public class AttachmentForm
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
private static final java.text.DateFormat simpleformat = new java.text.SimpleDateFormat("yyyy/MM/dd");private static final java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd hh:mm:ss");static { format.setLenient(true); }private Integer id;
public void setId(Integer id){
this.id = id;
}
public Integer getId(){
return this.id;
}
private String filetype;
public void setFiletype(String filetype){
this.filetype = filetype;
}
public String getFiletype(){
return this.filetype;
}
private Integer dbFile;
public void setDbFile(Integer dbFile){
this.dbFile = dbFile;
}
public Integer getDbFile(){
return this.dbFile;
}
private boolean wide;
public void setWide(boolean wide){
this.wide = wide;
}
public boolean isWide(){
return this.wide;
}
private Integer aszoom;
public void setAszoom(Integer aszoom){
this.aszoom = aszoom;
}
public Integer getAszoom(){
return this.aszoom;
}
private Integer asdetailed;
public void setAsdetailed(Integer asdetailed){
this.asdetailed = asdetailed;
}
public Integer getAsdetailed(){
return this.asdetailed;
}
private Integer asdefault;
public void setAsdefault(Integer asdefault){
this.asdefault = asdefault;
}
public Integer getAsdefault(){
return this.asdefault;
}
private float height;
public void setHeight(float height){
this.height = height;
}
public float getHeight(){
return this.height;
}
private float width;
public void setWidth(float width){
this.width = width;
}
public float getWidth(){
return this.width;
}
FormFile[] formFiles = new FormFile[10];
public void setFormFiles(FormFile[] formFiles){
this.formFiles = formFiles;
}
public FormFile[] getFormFiles(){
return this.formFiles;
}
public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request){	wide =false;
}
}
