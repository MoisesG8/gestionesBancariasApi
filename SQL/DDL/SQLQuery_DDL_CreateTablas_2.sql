USE bancoprueba;

/**TABLAS Y RELACIONES*/
BEGIN TRANSACTION
    CREATE TABLE Clientes(
        ClienteID INT IDENTITY(1,1) PRIMARY KEY,
        Nombre NVARCHAR(100),
        Apellido NVARCHAR(100),
        NumeroIdentificacion NVARCHAR(13),
        FechaNacimiento DATE,
        Direccion NVARCHAR(255),
        CorreoElectronico NVARCHAR(100),
        Telefono NVARCHAR(8),
        Estado NVARCHAR(1) DEFAULT 'A'
    );

    CREATE TABLE TiposDeCuentas(
        TipoCuentaID INT IDENTITY(1,1) PRIMARY KEY,
        NombreTipo NVARCHAR(50),
        Descripcion NVARCHAR(200)
    );

    CREATE TABLE TiposDeSolicitudes(
        TipoSolicitudID INT IDENTITY(1,1) PRIMARY KEY,
        NombreTipo NVARCHAR(50),
        Descripcion NVARCHAR(200)
    );

    CREATE TABLE Cuentas(
        CuentaID INT IDENTITY(1,1) PRIMARY KEY,
        ClienteID INT FOREIGN KEY REFERENCES Clientes(ClienteID),
        TipoCuentaID INT FOREIGN KEY REFERENCES TiposDeCuentas(TipoCuentaID),
        Monto DECIMAL(18,2),
        Estado NVARCHAR(20),
        NumeroCuenta NVARCHAR(14)
    );

    CREATE TABLE Chequeras(
        ChequeraID INT IDENTITY(1,1) PRIMARY KEY,
        CuentaID INT FOREIGN KEY REFERENCES Cuentas(CuentaID),
        CantidadCheques INT,
        EstadoChequera NVARCHAR(20),
        FechaVencimiento DATE,
        NumeroChequera NVARCHAR(11)
    );   

    CREATE TABLE Cheques(
    ChequeID INT IDENTITY(1,1) PRIMARY KEY,
    ChequeraID INT FOREIGN KEY REFERENCES Chequeras(ChequeraID),
    EstadoCheque NVARCHAR(20),
    MotivoActualizacion NVARCHAR(255)
    );

    CREATE TABLE Solicitudes(
    SolicitudID INT IDENTITY(1,1) PRIMARY KEY,
    ClienteID INT FOREIGN KEY REFERENCES Clientes(ClienteID),
    TipoSolicitudID INT FOREIGN KEY REFERENCES TiposDeSolicitudes(TipoSolicitudID),
    FechaSolicitud DATETIME,
    EstadoSolicitud NVARCHAR(20),
    MotivoActualizacion NVARCHAR(255)
    );

COMMIT;


/**SECUENCIAS*/
BEGIN TRANSACTION
    CREATE SEQUENCE NumeroChequeraSeq
    START WITH 1
    INCREMENT BY 1
    NO CACHE;
COMMIT;

BEGIN TRANSACTION
    CREATE SEQUENCE NumeroCuentaSeq
    START WITH 1
    INCREMENT BY 1
    NO CACHE;
COMMIT;
