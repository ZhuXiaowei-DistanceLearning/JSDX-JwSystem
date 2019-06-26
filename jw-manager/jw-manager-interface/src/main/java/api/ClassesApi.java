package api;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ClassesApi {
    @GetMapping("/classes/ViewXlsPage/{objectId}")
    public String ViewXlsPage(@PathVariable("objectId") String objectId, Model model);
}
