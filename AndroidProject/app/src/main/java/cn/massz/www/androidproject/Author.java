package cn.massz.www.androidproject;

public class Author {
	public int imgIcons;
	public String nameString;
	public String bookString;
	public String data;
	public Author(int imgIcons, String nameString, String bookString,String data) {
		super();
		this.imgIcons = imgIcons;
		this.nameString = nameString;
		this.bookString = bookString;
		this.data = data;
	}
	public int getImgIcons() {
		return imgIcons;
	}
	public void setImgIcons(int imgIcons) {
		this.imgIcons = imgIcons;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getBookString() {
		return bookString;
	}
	public void setBookString(String bookString) {
		this.bookString = bookString;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
