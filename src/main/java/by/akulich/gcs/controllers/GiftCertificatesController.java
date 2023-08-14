package by.akulich.gcs.controllers;

import by.akulich.gcs.dao.GiftCertificateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gift-certificates")
public class GiftCertificatesController {

    private final GiftCertificateDAO giftCertificateDAO;

    @Autowired
    public GiftCertificatesController(GiftCertificateDAO giftCertificateDAO) {
        this.giftCertificateDAO = giftCertificateDAO;
    }

    @GetMapping("/all")
    public String getAllGiftCertificates() {
        return giftCertificateDAO.getAll().toString();
    }

    @GetMapping("/{name}")
    public String getGiftCertificateByName(@PathVariable String name) {
        return String.valueOf(giftCertificateDAO.getByName(name));
    }

}
