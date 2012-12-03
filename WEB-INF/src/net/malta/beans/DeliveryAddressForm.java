package net.malta.beans;
import org.apache.struts.upload.FormFile;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
public class DeliveryAddressForm
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
private String kana;
public void setKana(String kana){
this.kana = kana;
}
public String getKana(){
return this.kana;
}
private int zipthree;
public void setZipthree(int zipthree){
this.zipthree = zipthree;
}
public int getZipthree(){
return this.zipthree;
}
private int zipfour;
public void setZipfour(int zipfour){
this.zipfour = zipfour;
}
public int getZipfour(){
return this.zipfour;
}
private String pref;
public void setPref(String pref){
this.pref = pref;
}
public String getPref(){
return this.pref;
}
private String buildingname;
public void setBuildingname(String buildingname){
this.buildingname = buildingname;
}
public String getBuildingname(){
return this.buildingname;
}
private String phone;
public void setPhone(String phone){
this.phone = phone;
}
public String getPhone(){
return this.phone;
}
private Integer publicUser;
public void setPublicUser(Integer publicUser){
this.publicUser = publicUser;
}
public Integer getPublicUser(){
return this.publicUser;
}
private String preferreddate;
public void setPreferreddate(String preferreddate){
this.preferreddate = preferreddate;
}
public String getPreferreddate(){
return this.preferreddate;
}
private String preferredtime;
public void setPreferredtime(String preferredtime){
this.preferredtime = preferredtime;
}
public String getPreferredtime(){
return this.preferredtime;
}
private Integer giftCard;
public void setGiftCard(Integer giftCard){
this.giftCard = giftCard;
}
public Integer getGiftCard(){
return this.giftCard;
}
private boolean hasgiftcard;
public void setHasgiftcard(boolean hasgiftcard){
this.hasgiftcard = hasgiftcard;
}
public boolean isHasgiftcard(){
return this.hasgiftcard;
}
private String name;
public void setName(String name){
this.name = name;
}
public String getName(){
return this.name;
}
private String address;
public void setAddress(String address){
this.address = address;
}
public String getAddress(){
return this.address;
}
private Integer prefecture;
public void setPrefecture(Integer prefecture){
this.prefecture = prefecture;
}
public Integer getPrefecture(){
return this.prefecture;
}
private Date preferreddatedate;
public void setPreferreddatedate(Date preferreddatedate){
this.preferreddatedate = preferreddatedate;
}
public Date getPreferreddatedate(){
return this.preferreddatedate;
}
private boolean preferreddatedateIsValid = false;
public void setPreferreddatedateIsValid(boolean preferreddatedateIsValid){
this.preferreddatedateIsValid = preferreddatedateIsValid;
}
public boolean isPreferreddatedateIsValid(){
return this.preferreddatedateIsValid;
}
private java.lang.String preferreddatedateAsRawString ="";
public java.lang.String getPreferreddatedateAsString(){
    return (preferreddatedate== null) ? null : simpleformat.format(preferreddatedate);
}
public void setPreferreddatedateAsString(java.lang.String preferreddatedate){
	this.preferreddatedateIsValid = true;
	this.preferreddatedateAsRawString = preferreddatedate;
try{
		if(StringUtils.isNotBlank(preferreddatedate)){ simpleformat.parse(preferreddatedate);}
}catch (java.text.ParseException pe){
this.preferreddatedateIsValid = false;
}
	if(preferreddatedateIsValid){
		try {
			this.preferreddatedate = (org.apache.commons.lang.StringUtils.isBlank(preferreddatedate)) ? null : simpleformat.parse(preferreddatedate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public void setPreferreddatedateAsRawString(java.lang.String preferreddatedate){
	this.preferreddatedateAsRawString = preferreddatedate;
}

public String getPreferreddatedateAsRawString(){
return this.preferreddatedateAsRawString;
}
private int preferreddatedateyear = 0;
public void setPreferreddatedateyear(int preferreddatedateyear){
    this.preferreddatedateyear = preferreddatedateyear;
}
public int getPreferreddatedateyear(){
   return this.preferreddatedateyear;
}
private int preferreddatedatemonth = 0;
public void setPreferreddatedatemonth(int preferreddatedatemonth){
    this.preferreddatedatemonth = preferreddatedatemonth;
}
public int getPreferreddatedatemonth(){
   return this.preferreddatedatemonth;
}
private int preferreddatedateday = 0;
public void setPreferreddatedateday(int preferreddatedateday){
    this.preferreddatedateday = preferreddatedateday;
}
public int getPreferreddatedateday(){
   return this.preferreddatedateday;
}
private int preferreddatedatehour = 0;
public void setPreferreddatedatehour(int preferreddatedatehour){
    this.preferreddatedatehour = preferreddatedatehour;
}
public int getPreferreddatedatehour(){
   return this.preferreddatedatehour;
}
private int preferreddatedateminute = 0;
public void setPreferreddatedateminute(int preferreddatedateminute){
    this.preferreddatedateminute = preferreddatedateminute;
}
public int getPreferreddatedateminute(){
   return this.preferreddatedateminute;
}
private int preferreddatedatesecound = 0;
public void setPreferreddatedatesecound(int preferreddatedatesecound){
    this.preferreddatedatesecound = preferreddatedatesecound;
}
public int getPreferreddatedatesecound(){
   return this.preferreddatedatesecound;
}
private boolean preferreddatedatechooser = false;
public void setPreferreddatedatechooser(boolean preferreddatedatechooser){
    this.preferreddatedatechooser = preferreddatedatechooser;
if(this.preferreddatedatechooser){
try{
   Date date = format.parse(preferreddatedateyear + "/" + preferreddatedatemonth + "/" + preferreddatedateday + " " + preferreddatedatehour+ ":" + preferreddatedateminute + ":" + preferreddatedatesecound);   this.preferreddatedate = date;
}catch (java.text.ParseException pe){
		pe.printStackTrace();
}
}}
public boolean isPreferreddatedatechooser(){
   return this.preferreddatedatechooser;
}
FormFile[] formFiles = new FormFile[10];
public void setFormFiles(FormFile[] formFiles){
this.formFiles = formFiles;
}
public FormFile[] getFormFiles(){
return this.formFiles;
}
public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request){	hasgiftcard =false;
}
}
