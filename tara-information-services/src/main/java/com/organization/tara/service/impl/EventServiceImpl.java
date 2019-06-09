package com.organization.tara.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.organization.tara.entities.Event;
import com.organization.tara.entities.Image;
import com.organization.tara.entities.Video;
import com.organization.tara.repository.EventRepository;
import com.organization.tara.repository.ImageRepository;
import com.organization.tara.repository.VideoRepository;
import com.organization.tara.service.EventService;
import com.organization.tara.visualobjects.Default;
import com.organization.tara.visualobjects.EventVO;
import com.organization.tara.visualobjects.GetEventVideoVO;
import com.organization.tara.visualobjects.High;
import com.organization.tara.visualobjects.Item;
import com.organization.tara.visualobjects.Maxres;
import com.organization.tara.visualobjects.Medium;
import com.organization.tara.visualobjects.PutEventVideo;
import com.organization.tara.visualobjects.Snippet;
import com.organization.tara.visualobjects.Standard;
import com.organization.tara.visualobjects.Thumbnails;
import com.organization.tara.visualobjects.UpdateEventVideoResponseVO;
import com.organization.tara.visualobjects.VideoYoutubeAPI;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private VideoRepository videoRepository;

	@Override
	public List<Event> getEvents(String period) {
		List<Event> eventList = null;
		if ("past".equals(period)) {
			eventList = eventRepository.getPastEvents(new Date());
		} else if ("upcoming".equals(period)) {
			eventList = eventRepository.getUpcomingEvents(new Date());
		}
		return eventList;
	}

	@Override
	public List<Event> getEvents(String period, int page, int size) {
		List<Event> eventList = null;
		if ("past".equals(period)) {
			eventList = eventRepository.getPastEvents(new Date(), PageRequest.of(page, size));
		} else if ("upcoming".equals(period)) {
			eventList = eventRepository.getUpcomingEvents(new Date(), PageRequest.of(page, size));
		}
		return eventList;
	}

	@Override
	public List<Event> getEvents(int page, int size) {

		return eventRepository.findAll(PageRequest.of(page, size)).getContent();

	}

	@Override
	public List<Event> getEvents(Date fromDate, Date toDate, int page, int size) {
		return eventRepository.getEvents(fromDate, toDate, PageRequest.of(page, size));

	}

	@Override
	public Event getEvent(int eventId) {
		return eventRepository.getOne(eventId);
	}

	@Override
	public List<Event> getEvents() {

		return eventRepository.findAll();
	}

	@Override
	public List<Event> getEvents(Date fromDate, Date toDate) {

		return eventRepository.getEvents(fromDate, toDate);
	}

	@Override
	public Event createEvent(EventVO eventVO) {

		Event event = new Event();
		event.setName(eventVO.getEventName());
		event.setDescription(eventVO.getDescription());
		event.setBroucher(createImage(eventVO.getBroucherUrl(), "BroucherImage", null));
		event.setEndTime(eventVO.getEndTime());
		event.setGuidelines(eventVO.getGuidelines());
		event.setRegistrationOpen(eventVO.isRegistrationOpen());
		event.setStartTime(eventVO.getStartTime());
		event.setVenue(eventVO.getVenue());

		return eventRepository.save(event);
	}

	@Override
	public String updateEventImages(List<String> eventImageUrls, int eventId) {

		Event event = eventRepository.getOne(eventId);
		if (event == null)
			return "Event:" + eventId + "doest exists";
		for (String url : eventImageUrls) {
			createImage(url, "EventImage", event);
		}

		return eventImageUrls.size() + " images added successfully";
	}

	@Override
	public List<UpdateEventVideoResponseVO> updateEventVideos(List<PutEventVideo> eventVideos, int eventId) {
		// TODO Auto-generated method stub
		Optional<Event> event = eventRepository.findById(eventId);
		if (!event.isPresent())
			return null;
		List<UpdateEventVideoResponseVO> responses = new ArrayList<>();
		List<Video> videos = new ArrayList<>();
		for (PutEventVideo eventVideo : eventVideos) {
			UpdateEventVideoResponseVO response = new UpdateEventVideoResponseVO();
			response.setVideoId(eventVideo.getId());
			Video video = createVideo(eventVideo, event.get(), response);

			if (response.getStatusCode() == 0) {
				response.setMessage("Video updated Successfully");
				response.setStatusCode(200);
				videos.add(video);
			}
			responses.add(response);

		}
		videoRepository.saveAll(videos);
		return responses;
	}

	@Override
	public List<GetEventVideoVO> getEventVideos(int page, int size, int eventId) {
		// TODO Auto-generated method stub

		Optional<Event> event = eventRepository.findById(eventId);
		if (!event.isPresent())
			return null;
		List<Video> videos = event.get().getVideos();

		List<GetEventVideoVO> eventVideos = new ArrayList<>();
		for (Video video : videos) {
			GetEventVideoVO eventVideo = new GetEventVideoVO();
			eventVideo.setId(video.getId());
			eventVideo.setUploadedDate(video.getUploadedDate());
			eventVideo.setUrl(video.getUrl());
			eventVideo.setThumbnails(getThumbnails(video.getId()));
			eventVideos.add(eventVideo);
		}
		return eventVideos;
	}

	@Override
	public String getEventImages(int page, int size, int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Image createImage(String url, String imageType, Event event) {
		Image image = new Image();
		image.setType(imageType);
		image.setUploadedDate(new Date());
		image.setUrl(url);
		image.setEvent(event);
		return imageRepository.save(image);
	}

	private Video createVideo(PutEventVideo eventVideo, Event event, UpdateEventVideoResponseVO respose) {
		Video video = new Video();
		video.setId(eventVideo.getId());
		video.setType(eventVideo.getVideoType());
		video.setUploadedDate(new Date());
		video.setUrl(eventVideo.getUrl());
		setThumbnails(eventVideo.getId(), respose);
		video.setEvent(event);
		return video;
	}

	private Thumbnails getThumbnails(String videoId) {
		// TODO Auto-generated method stub
		List<Image> images = imageRepository.findByVideo(videoId);
		Thumbnails thumbnails = new Thumbnails();
		for (Image image : images) {
			switch (image.getType()) {
			case ("THUMBNAIL_DEFAULT"):
				Default _default = new Default();
				_default.setUrl(image.getUrl());
				_default.setHeight(image.getHeight());
				_default.setWidth(image.getWidth());
				thumbnails.set_default(_default);
				break;
			case ("THUMBNAIL_MEDIUM"):
				Medium medium = new Medium();
				medium.setUrl(image.getUrl());
				medium.setHeight(image.getHeight());
				medium.setWidth(image.getWidth());
				thumbnails.setMedium(medium);
				break;
			case ("THUMBNAIL_HIGH"):
				High high = new High();
				high.setUrl(image.getUrl());
				high.setHeight(image.getHeight());
				high.setWidth(image.getWidth());
				thumbnails.setHigh(high);
				break;
			case ("THUMBNAIL_STANDARD"):
				Standard standard = new Standard();
				standard.setUrl(image.getUrl());
				standard.setHeight(image.getHeight());
				standard.setWidth(image.getWidth());
				thumbnails.setStandard(standard);
				break;
			case ("THUMBNAIL_MAXRES"):
				Maxres maxres = new Maxres();
				maxres.setUrl(image.getUrl());
				maxres.setHeight(image.getHeight());
				maxres.setWidth(image.getWidth());
				thumbnails.setMaxres(maxres);
				break;
			}
		}

		return thumbnails;
	}

	private List<Image> setThumbnails(String videoId, UpdateEventVideoResponseVO response) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String url = "https://www.googleapis.com/youtube/v3/videos?key=AIzaSyBsk2c4V402YrxLcuuMj-mHaGPWi9xgO28&part=snippet&id=";

		VideoYoutubeAPI videoYoutubeAPI = restTemplate
				.exchange(url.concat(videoId), HttpMethod.GET, entity, VideoYoutubeAPI.class).getBody();
		List<Image> images = new ArrayList<>();
		if (videoYoutubeAPI.items.isEmpty()) {
			response.setMessage("No Video found, Please check the videoId");
			response.setStatusCode(204);
			return null;
		}
		for (Item videoItem : videoYoutubeAPI.getItems()) {
			Snippet snippet = videoItem.getSnippet();
			if (snippet != null) {
				Thumbnails thumbnails = snippet.getThumbnails();
				if (thumbnails != null) {
					Default defaultTn = thumbnails.get_default();
					if (defaultTn != null) {
						Image image = new Image();
						image.setUrl(defaultTn.getUrl());
						image.setHeight(defaultTn.getHeight());
						image.setWidth(defaultTn.getWidth());
						image.setVideo(videoItem.getId());
						image.setUploadedDate(new Date());
						image.setType("THUMBNAIL_DEFAULT");
						images.add(image);
					}
					Medium mediumTn = thumbnails.getMedium();
					if (defaultTn != null) {
						Image image = new Image();
						image.setUrl(mediumTn.getUrl());
						image.setHeight(mediumTn.getHeight());
						image.setWidth(mediumTn.getWidth());
						image.setVideo(videoItem.getId());
						image.setUploadedDate(new Date());
						image.setType("THUMBNAIL_MEDIUM");
						images.add(image);
					}
					High highTn = thumbnails.getHigh();
					if (defaultTn != null) {
						Image image = new Image();
						image.setUrl(highTn.getUrl());
						image.setHeight(highTn.getHeight());
						image.setWidth(highTn.getWidth());
						image.setVideo(videoItem.getId());
						image.setType("THUMBNAIL_HIGH");
						image.setUploadedDate(new Date());
						images.add(image);
					}
					Standard standardTn = thumbnails.getStandard();
					if (defaultTn != null) {
						Image image = new Image();
						image.setUrl(standardTn.getUrl());
						image.setHeight(standardTn.getHeight());
						image.setWidth(standardTn.getWidth());
						image.setVideo(videoItem.getId());
						image.setUploadedDate(new Date());
						image.setType("THUMBNAIL_STANDARD");
						images.add(image);
					}
					Maxres maxResTn = thumbnails.getMaxres();
					if (defaultTn != null) {
						Image image = new Image();
						image.setUrl(maxResTn.getUrl());
						image.setHeight(maxResTn.getHeight());
						image.setWidth(maxResTn.getWidth());
						image.setVideo(videoItem.getId());
						image.setUploadedDate(new Date());
						image.setType("THUMBNAIL_MAXRES");
						images.add(image);
					}
				}
			}
		}
		return imageRepository.saveAll(images);
	}

}
