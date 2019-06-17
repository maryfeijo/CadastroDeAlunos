package com.poo.view;

import java.util.Scanner;
import com.poo.dao.AlunoDAO;
import com.poo.model.Aluno;

public class CRUDAluno {
	private void create()
	{
		try {
			
			Aluno aluno = new Aluno();
			AlunoDAO dao = new AlunoDAO();
			
			System.out.println("Matricula:");
			Scanner sc = new Scanner(System.in);
			
			aluno.setMatricula(sc.nextInt());
			
			System.out.println("Nome:");
			aluno.setNome(sc.nextLine());
			
			System.out.println("Email:");
			aluno.setEmail(sc.nextLine());
			
			System.out.println("Senha:");
			aluno.setEmail(sc.nextLine());
			
			dao.create(aluno);

		} finally {
			// TODO: handle finally clause
			System.out.println("Fim inserção!");
		}
		

	}
	
	private void read()
	{
		AlunoDAO dao = new AlunoDAO();
		
		for (Aluno a : dao.read()) {
			
			System.out.println("***********************************");
			System.out.println("Matricula: "+ a.getMatricula());
			System.out.println("Nome: "+ a.getNome());
			System.out.println("Email: "+ a.getEmail());
			System.out.println("Senha: "+ a.getSenha());
			
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CRUDAluno crud = new CRUDAluno();		
		
		crud.create();
		crud.read();
		
		
	}

}


