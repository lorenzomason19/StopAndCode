
INSERT INTO coordinate (id, lat, lng) VALUES (1, 45.06666564941406, 7.699999809265137);
INSERT INTO coordinate (id, lat, lng) VALUES (2, 45.4642, 9.1900);
INSERT INTO coordinate (id, lat, lng) VALUES (3, 41.9028, 12.4964);

-- Torino 
INSERT INTO comuni (id, nome, codice_catastale, provincia, cap, prefisso, mail, pec, telefono, fax, id_coordinata) 
VALUES (1, 'Torino', 'L219', '001', '10121', '011', 'urc@comune.torino.it', 'ProtocolloGenerale@cert.comune.torino.it', '+39 011 01121111', '+39 011 01122723', 1);

--Milano
INSERT INTO comuni (id, nome, codice_catastale, provincia, cap, prefisso, mail, pec, telefono, fax, id_coordinata) 
VALUES (2, 'Milano', 'F205', '015', '20121', '02', 'info@comune.milano.it', 'protocollo@pec.comune.milano.it', '+39 02 88441', '+39 02 88442000', 2);

--Roma
INSERT INTO comuni (id, nome, codice_catastale, provincia, cap, prefisso, mail, pec, telefono, fax, id_coordinata) 
VALUES (3, 'Roma', 'H501', '058', '00118', '06', 'info@comune.roma.it', 'protocollo@pec.comune.roma.it', '+39 06 67101', '+39 06 67102000', 3);
