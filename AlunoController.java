
package com.poo.controller;

import java.util.Scanner;

import com.poo.dao.AlunoDAO;
import com.poo.model.Aluno;

public class AlunoController {

	public void create(Aluno aluno)
	{
		try {
			
			AlunoDAO dao = new AlunoDAO();
			
			dao.create(aluno);

		} finally {
			// TODO: handle finally clause
			System.out.println("Fim inserção!");
		}
	}
}
		

	
