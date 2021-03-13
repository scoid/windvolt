/*
    This file is part of windvolt.org.

    Copyright (c) 2020 Max Sumer

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.windvolt.system.device_store;

public class DeviceModel {

    String device_name = "<name>";
    public String getName() { return device_name; }
    public void setName(String value) { device_name = value; }

    String device_type = "0";
    public String getType() { return device_type; }
    public void setType(String value) { device_type = value; }

    String device_power = "100";
    public String getPower() { return device_power; }
    public void setPower(String value) { device_power = value; }

}
