package br.com.masters3.beans;

public class Endereco {
private int id;
private String logradouro;
private String numero;
private String bairro;
private String cidade;
private String cep;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLogradouro() {
	return logradouro;
}
public void setLogradouro(String logradouro) {
	this.logradouro = logradouro;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public String getBairro() {
	return bairro;
}
public void setBairro(String bairro) {
	this.bairro = bairro;
}
public String getCidade() {
	return cidade;
}
public void setCidade(String cidade) {
	this.cidade = cidade;
}
public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}
public Endereco(int id, String logradouro, String numero, String bairro, String cidade, String cep) {
	super();
	this.id = id;
	this.logradouro = logradouro;
	this.numero = numero;
	this.bairro = bairro;
	this.cidade = cidade;
	this.cep = cep;
}
public Endereco() {
	super();
}

}
