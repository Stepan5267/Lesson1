package ru.zelmex.bankapp.repository;
import ru.zelmex.bankapp.model.Record;
public class RecordDao extends BaseDao<Record> {
    public RecordDao() { super(Record.class); }
}