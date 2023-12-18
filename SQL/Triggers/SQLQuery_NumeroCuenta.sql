CREATE TRIGGER TR_Cuentas_Insert
ON Cuentas
INSTEAD OF INSERT
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO Cuentas (ClienteID, TipoCuentaID, Monto, Estado, NumeroCuenta)
    SELECT
        ClienteID,
        TipoCuentaID,
        Monto,
        Estado,
        'CU' + RIGHT('000000000000' + CAST(NEXT VALUE FOR NumeroCuentaSeq AS NVARCHAR(12)), 12)
    FROM inserted;
END;
