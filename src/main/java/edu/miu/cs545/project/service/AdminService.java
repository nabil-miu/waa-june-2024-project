package edu.miu.cs545.project.service;

import edu.miu.cs545.project.model.entity.User;

public interface AdminService extends CrudService<User, Long> {
    void deactivateUser(Long id);
    void activateUser(Long id);
}
