package mk.ukim.finki.emt.productmanagement.services.form;

import lombok.Data;
import mk.ukim.finki.emt.productmanagement.domain.models.RepairGuarantee;
import mk.ukim.finki.emt.productmanagement.domain.models.SerialNumber;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Description;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Manufacturer;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.Model;
import mk.ukim.finki.emt.productmanagement.domain.valueobjects.RepairId;

@Data
public class TVProductForm {
    private Model model;
    private SerialNumber serialNumber;
    private Manufacturer manufacturer;
    private Description defect;
    private RepairGuarantee repairGuarantee;
    private RepairId repairId;
}
