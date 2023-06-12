CREATE DATABASE JavaGraovacMovies;
go
USE JavaGraovacMovies;
go

CREATE TABLE PeoplesForaAuth (
	IDUser INT PRIMARY KEY IDENTITY,
	username NVARCHAR(300) UNIQUE,
	passwords NVARCHAR(300),
	administrator NVARCHAR(2)
);
GO
CREATE TABLE Movies (
	IDMovie INT PRIMARY KEY IDENTITY,
	MovieName NVARCHAR(300)
);
GO
CREATE TABLE PeoplesForMovies (
	IDUserForMovies INT PRIMARY KEY IDENTITY,
	names NVARCHAR(300)
);
GO
CREATE TABLE MoviesAndActors (
	IDMoviesAndActors INT PRIMARY KEY IDENTITY,
	MoviesID int NOT NULL,
	UserID int NOT NULL,
	FOREIGN KEY (MoviesID) REFERENCES Movies(IDMovie),
	FOREIGN KEY (UserID) REFERENCES PeoplesForMovies(IDUserForMovies)
);
GO
CREATE TABLE MoviesAndDirectors (
	IDMoviesAndDirectors INT PRIMARY KEY IDENTITY,
	MoviesID int NOT NULL,
	UserID int NOT NULL,
	FOREIGN KEY (MoviesID) REFERENCES Movies(IDMovie),
	FOREIGN KEY (UserID) REFERENCES PeoplesForMovies(IDUserForMovies)
);
GO
------------------------------------------------------------------------------
INSERT INTO PeoplesForaAuth(username, passwords,administrator) VALUES('admin', 'admin', 'da')
GO
-------------------INSERT PROCEDURES-----------------------------------------
CREATE or ALTER PROCEDURE createUser
	@username NVARCHAR(300),
	@passwords NVARCHAR(300),
	@IDUser INT OUTPUT
AS 
BEGIN 
	INSERT INTO PeoplesForaAuth(username, passwords,administrator) VALUES(@username, @passwords, 'ne')
	SET @IDUser = SCOPE_IDENTITY()
END
GO
CREATE or ALTER PROCEDURE createMovies
	@MovieName NVARCHAR(300),
	@IDMovie INT OUTPUT
AS 
BEGIN 
	INSERT INTO Movies (MovieName) VALUES (@MovieName)
	SET @IDMovie = SCOPE_IDENTITY()
END
GO
CREATE or ALTER PROCEDURE deleteUser
	@IDUser INT	 
AS 
BEGIN 
	DELETE  
	FROM 
			PeoplesForaAuth
	WHERE 
		IDUser = @IDUser
END
GO
CREATE or ALTER PROCEDURE updateUser
	@IDUser int,
	@username NVARCHAR(300),
	@passwords NVARCHAR(300),
	@administrator NVARCHAR(2)
AS
BEGIN 
	UPDATE PeoplesForaAuth SET 
		username = @username,
		passwords = @passwords,
		administrator = @administrator
	WHERE 
		IDUser = @IDUser
END
go
CREATE or ALTER PROCEDURE authUser
	@username NVARCHAR(300),
	@passwords NVARCHAR(300)
AS
BEGIN 
	Select * from PeoplesForaAuth as pfa where pfa.username=@username and pfa.passwords=@passwords
END
GO

CREATE or ALTER PROCEDURE selectUser
	@IDUser INT
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		PeoplesForaAuth
	WHERE 
		IDUser = @IDUser
END
GO

CREATE or ALTER PROCEDURE selectUsers
AS 
BEGIN 
	SELECT * FROM PeoplesForaAuth
END
GO


