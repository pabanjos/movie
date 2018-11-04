package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.javabeans.Data;
import model.persistence.DaoManager;

@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			String acao;
			
			if ((acao = req.getParameter("acao")) != null) {
				if (acao.equals("cadastrar")) {
					Data data = new Data();
					data.setWhat(req.getParameter("what"));
					data.setTitle(req.getParameter("title"));
					data.setGenre(req.getParameter("genre"));
					data.setProtagonist(req.getParameter("protagonist"));
					data.setDirector(req.getParameter("director"));
					data.setExtra(req.getParameter("extra"));
					data.setReleased(Integer.parseInt(req.getParameter("released")));
					data.setRating(Double.parseDouble(req.getParameter("rating")));
					data.setPoster(data.getTitle().concat(" ").concat(data.getReleased().toString()).concat(".jpg"));
					new DaoManager().create(data);
					escrever(ler().concat(data.toSyntax()));

				}/* else if (acao.equals("atualizar")) {
					Data data = new Data();
					data.setIdData(Integer.parseInt(req.getParameter("idData")));
					data.setWhat(req.getParameter("what"));
					data.setPoster(req.getParameter("poster"));
					data.setTitle(req.getParameter("title"));
					data.setGenre(req.getParameter("genre"));
					data.setProtagonist(req.getParameter("protagonist"));
					data.setDirector(req.getParameter("director"));
					data.setExtra(req.getParameter("extra"));
					data.setReleased(Integer.parseInt(req.getParameter("released")));
					data.setRating(Double.parseDouble(req.getParameter("rating")));
					new DaoManager().update(data);

				} else if (acao.equals("deletar")) {
					new DaoManager().delete(Integer.parseInt(req.getParameter("idData")));
				}*/
			}
			List<Data> lista = new DaoManager().read();
			String json = new Gson().toJson(lista);
			res.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			res.getWriter().flush();
			res.getWriter().close();
		}
	}

	public String ler() throws Exception {
		String syntax = "";
		File arquivo = new File("C:\\script\\arquivo.sql");
		if (!arquivo.exists()) {
			System.err.println("Falha na leitura: arquivo não existe !");
		} else {
			FileReader fr = new FileReader("C:\\script\\arquivo.sql");
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				syntax += br.readLine();
				syntax += "\n";
			}
			br.close();
		}
		return syntax;
	}
	
	public void escrever(String syntax) throws Exception {
		File diretorio = new File("C:\\script\\");
		if (!diretorio.exists()) {
			System.out.println("Diretório e arquivo criados !");
			diretorio.mkdir();
		}
		FileWriter fw = new FileWriter("C:\\script\\arquivo.sql");
		fw.write(syntax);
		fw.flush();
		fw.close();
	}

}