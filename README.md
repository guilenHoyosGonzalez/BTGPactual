// QUERY:
SELECT a.nombre as nombre 
FROM cliente a, inscripcion b, producto c, sucursal d, disponibilidad e, visitan n
WHERE a.id = b.idCliente 
AND c.id = b.idProducto
AND c.id = e.idProducto
AND d.id = e.idSucursal
AND a.id = n.idCliente
AND d.id =n. idSucursal
