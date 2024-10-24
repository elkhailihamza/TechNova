CREATE TABLE IF NOT EXISTS users(
	id SERIAL PRIMARY KEY,
	user_name VARCHAR(255) NOT NULL UNIQUE,
	pass_word VARCHAR(255) NOT NULL,

	CONSTRAINT username_above_three_chars CHECK (LENGTH(users.user_name) > 3)
);