DROP DATABASE IF EXISTS Exam;
CREATE DATABASE Exam DEFAULT CHARACTER SET 'utf8';
USE Exam;
--  Вопросы
CREATE TABLE Question (
	idQuestion		INT UNSIGNED 	NOT NULL  AUTO_INCREMENT COMMENT "Код вопроса",
	textQuestion 	CHAR(100) 		COMMENT "Текст вопроса",
	
	CONSTRAINT xidQuestion PRIMARY KEY (idQuestion)
) COMMENT "Таблица вопросов";

-- Ответы
CREATE TABLE Answer (
	idAnswer				INT UNSIGNED 	NOT NULL  AUTO_INCREMENT COMMENT "Код ответа",
	idQuestion_parent 		INT UNSIGNED 	COMMENT "Код вопроса родителя",
	textAnswer		 		CHAR(100) 		COMMENT "Текст ответа",
	isRight 				BOOLEAN 		COMMENT "Правильный ли ответ",
	
	CONSTRAINT xidAnswer PRIMARY KEY (idAnswer),
	INDEX xidQuestion_parent (idQuestion_parent),
	CONSTRAINT  fidQuestion_parent FOREIGN KEY (idQuestion_parent)
		REFERENCES Question(idQuestion) ON DELETE CASCADE
) COMMENT "Таблица ответов";
