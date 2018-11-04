package model.persistence;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.javabeans.Data;

public class DaoManager extends Dao {

	String create = "insert into Data values (null,?,?,?,?,?,?,?,?,?)";
	String read = "select * from Data";
	String readMovies = "select * from Data where what <> 'Game' and what <> 'TvShow' order by released desc";
	String update = "update Data set what=?, poster=?, title=?, genre=?, protagonist=?, director=?, extra=?, released=?, rating=? where idData=?";
	String delete = "delete from Data where idData=?";

	public void create(final Data data) throws Exception {
		open();
		ps = con.prepareStatement(create);
		ps.setString(1, data.getWhat());
		ps.setString(2, data.getPoster());
		ps.setString(3, data.getTitle());
		ps.setString(4, data.getGenre());
		ps.setString(5, data.getProtagonist());
		ps.setString(6, data.getDirector());
		ps.setString(7, data.getExtra());
		ps.setInt(8, data.getReleased());
		ps.setDouble(9, data.getRating());
		ps.execute();
		con.close();
	}

	public Map<Integer, List<Data>> readMovies() throws Exception {
		open();
		ps = con.prepareStatement(readMovies);
		rs = ps.executeQuery();
		final List<Data> list = new ArrayList<Data>();
		while (rs.next()) {
			list.add(new Data(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDouble(10)));
		}
		con.close();
		
		Map<Integer, List<Data>> map = list.stream()
				.sorted(Comparator.comparingInt(Data::getReleased).reversed())
				.collect(Collectors.groupingBy(Data::getReleased,
			            LinkedHashMap::new, Collectors.toList()));
		return map;
	}

	public List<Data> read() throws Exception {
		open();
		ps = con.prepareStatement(read);
		rs = ps.executeQuery();
		final List<Data> list = new ArrayList<Data>();
		while (rs.next()) {
			list.add(new Data(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDouble(10)));
		}
		con.close();
		return list;
	}

	public void update(final Data data) throws Exception {
		open();
		ps = con.prepareStatement(update);
		ps.setString(1, data.getWhat());
		ps.setString(2, data.getPoster());
		ps.setString(3, data.getTitle());
		ps.setString(4, data.getGenre());
		ps.setString(5, data.getProtagonist());
		ps.setString(6, data.getDirector());
		ps.setString(7, data.getExtra());
		ps.setInt(8, data.getReleased());
		ps.setDouble(9, data.getRating());
		ps.setInt(10, data.getIdData());
		ps.execute();
		con.close();
	}

	public void delete(final Integer idData) throws Exception {
		open();
		ps = con.prepareStatement(delete);
		ps.setInt(1, idData);
		ps.close();
		con.close();
	}
}