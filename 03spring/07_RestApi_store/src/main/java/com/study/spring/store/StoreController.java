package com.study.spring.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StoreController {

	@Autowired
	IStoreDao dao;

	@GetMapping("/")
	public String root() {
		return "store root";
	}

//	store
	@GetMapping("api/store")
	public List<StoreDto> listStore() {
		return dao.findAll();
	}

	@PutMapping("api/store")
	public void createStore(@RequestBody StoreDto req) {
		log.info("--------createStore() name:", req.name);
		dao.createStore(req);
	}

	@GetMapping("/api/store/{id}")
	public StoreDto getStore(@PathVariable("id") Long id) {
		return dao.storeView(id);
	}

	@GetMapping("/api/store/view")
	public StoreDto getStoreView(@RequestParam("id") Long id) {
		log.info("--------getStoreView() id:" + id);
		return dao.storeView(id);
	}

	@DeleteMapping("/api/store")
	public void deleteStore(@RequestParam("id") Long id) {
		dao.deleteStore(id);
	}

//	menu	
	@GetMapping("api/menu")
	public List<MenuDto> listMenu() {
		return dao.findMenuAll();
	}

	@PutMapping("api/menu")
	public void createMenu(@RequestBody MenuDto req) {
		log.info("--------createMenu() name:", req.name);
		dao.createMenu(req);
	}

	@GetMapping("/api/menu/view")
	public MenuDto getMenuView(@RequestParam("id") Long id) {
		return dao.menuView(id);
	}

	@GetMapping("/api/menuStore")
	public List<MenuDto> menuStoreView(@RequestParam("store_id") Long store_id) {
		return dao.findMenuByStoreID(store_id);
	}

	@GetMapping("/api/storemenuall")
	public List<StoreMenuDto> sotoreMenuList() {
		return dao.storeAndMenuAll();
	}

	@GetMapping("/api/menuAndStore")
	public List<MenuStoreDto> menuAndStore() {
		return dao.menuAndStore();
	}

//	@GetMapping("/api/menuAndStoreJoin")
//	public List<MenuStoreDto> menuAndStoreJoin() {
//		return dao.menuAndStoreJoin();
//	}

//	@GetMapping("/api/currentuser")
//	public String currentuser() {
//		return dao.current_user();
//	}

}
