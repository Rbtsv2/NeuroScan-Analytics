@RestController
@RequestMapping("/api/patients")
public class PatientDataController {
    private final PatientDataService service;

    public PatientDataController(PatientDataService service) {
        this.service = service;
    }

    @GetMapping
    public List<PatientData> getAllPatients() {
        return service.getAllPatients();
    }

    @PostMapping
    public PatientData addPatient(@RequestBody PatientData data) {
        return service.savePatient(data);
    }
}
