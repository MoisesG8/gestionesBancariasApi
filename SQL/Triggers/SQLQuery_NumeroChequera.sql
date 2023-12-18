CREATE TRIGGER TR_Chequeras_Insert
ON Chequeras
INSTEAD OF INSERT
AS
BEGIN
    SET NOCOUNT ON;

    INSERT INTO Chequeras (CuentaID, CantidadCheques, EstadoChequera, FechaVencimiento, NumeroChequera)
    SELECT
        CuentaID,
        CantidadCheques,
        EstadoChequera,
        FechaVencimiento,
        'CU' + RIGHT('000000000' + CAST(INSERTED.ChequeraID AS NVARCHAR(9)), 9)
    FROM INSERTED;
END;
