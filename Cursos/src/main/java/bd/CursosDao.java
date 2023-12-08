package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CursosDao {

    private Connection conexao;

    public CursosDao() {
        
    }

    public void inserirCurso(Cursos curso) throws SQLException {
    	Conexao con = new Conexao();
        try  {
            String sql = "INSERT INTO cursos (id, nome, descricao, duracaoEmHoras, preco, docente) VALUES (?, ?, ?, ?, ?, ?)";

        	PreparedStatement pst = con.getConnection().prepareStatement(sql);
        	pst.setInt(1, curso.getId());
        	pst.setString(2, curso.getNome());
        	pst.setString(3, curso.getDescricao());
        	pst.setInt(4, curso.getDuracaoEmHoras());
        	pst.setDouble(5, curso.getPreco());
        	pst.setString(6, curso.getDocente());
        	pst.executeUpdate();
        } catch(Exception e) {
        	e.printStackTrace();
        	}
        con.desconectar();
    }

    public List<Cursos> listarCursos() {
    	Cursos c = new Cursos();
        List<Cursos> cursos = new ArrayList<>();
    	Conexao con = new Conexao();
		String sql = "SELECT * FROM cursos";

        try {
        	PreparedStatement pst = con.getConnection().prepareStatement(sql);
			
			ResultSet res = pst.executeQuery();
            while (res.next()) {
                
               c.setId(res.getInt("id"));
               c.setNome(res.getString("nome"));
               c.setDescricao(res.getString("descricao"));
               c.setDuracaoEmHoras(res.getInt("duracaoEmHoras"));
               c.setPreco(res.getDouble("preco"));
               c.setDocente(res.getString("docente"));
               cursos.add(c);
            } 
        }catch(Exception e) {
        	e.printStackTrace();
        	}
        return cursos;
    }

    public void excluirCurso(Cursos c)  {
    	Conexao con = new Conexao();

        String sql = "DELETE FROM cursos WHERE id = ?";
        try  {
        	PreparedStatement statement = con.getConnection().prepareStatement(sql);
            statement.setInt(1, c.getId());
            statement.execute();
        } catch(Exception e) {
        	e.printStackTrace();
        	}
    }

    public void alterarCurso(Cursos curso) {
    	Conexao con = new Conexao();

        String sql = "UPDATE cursos SET nome = ?, descricao = ?, duracaoEmHoras = ?, preco = ?, docente = ? WHERE id = ?";
        System.out.println(sql);
        try  {
        	PreparedStatement statement = con.getConnection().prepareStatement(sql);
        	statement.setString(1, curso.getNome());
            statement.setString(2, curso.getDescricao());
            statement.setInt(3, curso.getDuracaoEmHoras());
            statement.setDouble(4, curso.getPreco());
            statement.setString(5, curso.getDocente());
            statement.setInt(6, curso.getId());
            System.out.println(curso.getId());
            statement.executeUpdate();
        }catch(Exception e) {
        	e.printStackTrace();
        	}
    }
}
