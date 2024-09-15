package edu.mum.cs.cs425.studentmgmt.service.Impl;

import edu.mum.cs.cs425.studentmgmt.model.ClassRoom;
import edu.mum.cs.cs425.studentmgmt.repository.IClassRoomRepository;
import edu.mum.cs.cs425.studentmgmt.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomService implements IClassRoomService {
    @Autowired
    private IClassRoomRepository classRoomRepository;
    public ClassRoom createClassRoom(ClassRoom room){
        return classRoomRepository.save(room);
    }
}
