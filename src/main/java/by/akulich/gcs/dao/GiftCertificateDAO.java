package by.akulich.gcs.dao;

import by.akulich.gcs.models.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GiftCertificateDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GiftCertificateDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<GiftCertificate> getAll() {
        return jdbcTemplate.query("SELECT * FROM gift_certificate", new GiftCertificateMapper());
    }

    public GiftCertificate getByName(String name) {
        return jdbcTemplate.query("SELECT * FROM gift_certificate WHERE name=?", new Object[]{name}, new GiftCertificateMapper())
                .stream().findAny().orElse(null);
    }
}
