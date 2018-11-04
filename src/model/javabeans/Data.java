package model.javabeans;

public class Data {
	private Integer idData;
	private String what = "";
	private String poster = "";
	private String title = "";
	private String genre = "";
	private String protagonist = "";
	private String director = "";
	private String extra = "";
	private Integer released = 0;
	private Double rating = 0.0;
	private String caminhoPoster;
	
	public Data() {
		super();
	}
	
	public Data(Integer idData, String what, String poster, String title, String genre, String protagonist, String director, String extra, Integer released, Double rating) {
		super();
		this.idData = idData;
		this.what = what;
		this.poster = poster;
		this.title = title;
		this.genre = genre;
		this.protagonist = protagonist;
		this.director = director;
		this.extra = extra == null ? "" : extra;
		this.released = released;
		this.rating = rating;
		this.caminhoPoster = "Posters/" + getGenre() + "/" + getPoster();
	}
	
	
	@Override
	public String toString() {
		return "Data [released=" + released + "]";
	}

	public String toSyntax() {
		return "insert into Data values (null,'" + what + "','" + poster + "','" + title + "','" + genre + "','"
				+ protagonist + "','" + director + "','" + extra + "'," + released + "," + rating + ");\n";
	}

	public Integer getIdData() {
		return idData;
	}

	public void setIdData(Integer idData) {
		this.idData = idData;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getProtagonist() {
		return protagonist;
	}

	public void setProtagonist(String protagonist) {
		this.protagonist = protagonist;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public Integer getReleased() {
		return released;
	}

	public void setReleased(Integer released) {
		this.released = released;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getCaminhoPoster() {
		return caminhoPoster;
	}

	public void setCaminhoPoster(String caminhoPoster) {
		this.caminhoPoster = caminhoPoster;
	}

}
