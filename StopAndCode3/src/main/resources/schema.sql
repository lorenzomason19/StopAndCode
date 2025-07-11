CREATE TABLE coordinate (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  lat DOUBLE NOT NULL,
  lng DOUBLE NOT NULL
);

CREATE TABLE comuni (
  codice_catastale VARCHAR(4) PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  provincia VARCHAR(10) NOT NULL,
  cap VARCHAR(5) NOT NULL,
  prefisso VARCHAR(4) NOT NULL,
  mail VARCHAR(255) NOT NULL,
  pec VARCHAR(255) NOT NULL,
  telefono VARCHAR(30) NOT NULL,
  fax VARCHAR(30) NOT NULL,
  id_coordinata BIGINT NOT NULL,
  FOREIGN KEY (id_coordinata) REFERENCES coordinate(id) ON DELETE CASCADE
);

INSERT INTO coordinate (id, lat, lng) VALUES 
(1, 41.8930549621582, 12.48277759552002),
(2, 45.46694564819336, 9.1899995803833),
(3, 40.83333206176758, 14.25);

INSERT INTO comuni (codice_catastale, nome, provincia, cap, prefisso, mail, pec, telefono, fax, id_coordinata) VALUES 
('H501', 'Roma', '058', '00186', '06', 'ld.gabinetto@comune.roma.it', 'protocollo.segretariato@pec.comune.roma.it', '+39 06/67102001', '+39 06/67103590', 1),
('F205', 'Milano', '015', '20141', '02', 'stl.informagiovani@comune.milano.it', 'protocollo@postacert.comune.milano.it', '+39 02 0202', '+39 02 88452170', 2),
('F839', 'Napoli', '063', '80127', '081', 'sindaco@comune.napoli.it', 'protocollo@pec.comune.napoli.it', '+39 081 7951111', '+39 081 7955509', 3);

-- Reset della sequenza auto-increment per coordinate
ALTER TABLE coordinate ALTER COLUMN id RESTART WITH 4;
