/**
INSERTS
*/

BEGIN TRANSACTION
    INSERT INTO TiposDeCuentas (NombreTipo, Descripcion)
    VALUES('Monetaria', 'Esta puede ser manejada por medio de chequera o tarjeta de débito y se puede abrir en quetzales o dólares.'),
    ('Ahorro', 'Las cuentas de ahorro son un tipo de cuenta bancaria que le permite ahorrar dinero y ganar intereses sobre su saldo.');
COMMIT;

BEGIN TRANSACTION
    INSERT INTO TiposDeSolicitudes (NombreTipo, Descripcion)
    VALUES('Aperturar Cuenta', 'Apertura de una nueva cuenta');
COMMIT;

BEGIN TRANSACTION
    INSERT INTO Clientes (Nombre, Apellido, NumeroIdentificacion, FechaNacimiento, Direccion, CorreoElectronico, Telefono, Estado)
    VALUES ('Oliver', 'Hernandez', '3423856182201', '1998-11-07', 'Jutiapa', 'oliver@cliente.com', '30306187', 'A'),
           ('Moisés', 'Gonzalez', '3424456182201', '1998-06-20', 'Jutiapa', 'moises@cliente.com', '33424930', 'A'),
           ('Erick', 'Villanueva', '3620456182201', '1991-08-05', 'Ciudad de Cerro Gordo', 'moises@cliente.com', '78443965', 'A'),
           ('Hector', 'Moreira', '3423555382201', '1997-08-11', 'Zona 16', 'hector@cliente.com', '57156731', 'A');
COMMIT;

BEGIN TRANSACTION
    INSERT INTO Cuentas (ClienteID, TipoCuentaID, Monto, Estado)
    VALUES (1, 1, 1000.00, 'Activa');
COMMIT;


BEGIN TRANSACTION
    INSERT INTO Chequeras (CuentaID, CantidadCheques, EstadoChequera, FechaVencimiento)
    VALUES(1, 30, 'Activa', '2023-12-31');
COMMIT;

BEGIN TRANSACTION
    SELECT cl.Nombre, cu.Estado, cu.Monto, cu.NumeroCuenta, tc.NombreTipo FROM Clientes as cl
    INNER JOIN Cuentas as cu
    ON cl.ClienteID = cu.ClienteID
    INNER JOIN TiposDeCuentas AS tc
    ON tc.TipoCuentaID = cu.TipoCuentaID
COMMIT;