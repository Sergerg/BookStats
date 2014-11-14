CREATE TABLE IF NOT EXISTS tbl_users ( 
			id serial PRIMARY KEY, 
			login varchar(100) UNIQUE NOT NULL, 
			created timestamp DEFAULT CURRENT_TIMESTAMP );

CREATE TABLE IF NOT EXISTS tbl_authors (
			id serial PRIMARY KEY,
      created timestamp DEFAULT CURRENT_TIMESTAMP,
			nick varchar(100) UNIQUE NOT NULL,
			family varchar(100),
			name varchar(100),
			fullname varchar(100),
			engname varchar(100)
			);

CREATE TABLE IF NOT EXISTS tbl_links (
			id serial PRIMARY KEY,
      created timestamp DEFAULT CURRENT_TIMESTAMP,
			title varchar(100) UNIQUE NOT NULL,
			url varchar(255),
			note varchar(4096),
			ban bool
			);
