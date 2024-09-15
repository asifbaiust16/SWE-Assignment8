package edu.mum.cs.cs425.studentmgmt.service.Impl;

import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ITranscriptRepository;
import edu.mum.cs.cs425.studentmgmt.service.ITranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptService implements ITranscriptService {
    @Autowired
    private ITranscriptRepository transcriptRepository;
    public Transcript createTranscript(Transcript transcript){
        return transcriptRepository.save(transcript);
    }
}
