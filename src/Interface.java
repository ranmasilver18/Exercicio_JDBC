
public interface Interface {
	public void Conectar(String dblink, String dbuser, String dbpassword);
	public void Consultar(String dbquery);
	public void Desconectar();
	public int CRUD(String dbquery);
}
