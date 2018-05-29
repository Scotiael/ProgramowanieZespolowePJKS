INSERT INTO role (role_id, role) VALUES (1, 'admin');
INSERT INTO role (role_id, role)VALUES (2, 'user');
INSERT INTO user (userid, name,surname,email,password,role_id)
   VALUES (1, 'admin', 'admin', 'admin', '$2a$10$IGPMWuTMlO9mF59ZLbW2geaTeqaR0m6.iFk7UofcT7QhJAXJO3ZQi', 1)
