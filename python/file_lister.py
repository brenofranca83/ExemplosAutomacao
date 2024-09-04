import os
from file_filter import FileFilter

class FileLister:
    def __init__(self, folder_path):
        self.folder_path = folder_path
        self.file_filter = FileFilter()

    def list_files(self):
        result = []
        if os.path.exists(self.folder_path) and os.path.isdir(self.folder_path):
            for f in os.listdir(self.folder_path):
                file_path = os.path.join(self.folder_path, f)
                if os.path.isfile(file_path): 
                    result.append(f)
            return result
        else:
            print("The folder path provided does not exist or is not a directory.")
            return []

    def list_files_with_filter(self, extension=None, keyword=None):
        file_list = self.list_files()
        if extension:
            file_list = self.file_filter.filter_by_extension(file_list, extension)
        if keyword:
            file_list = self.file_filter.filter_by_keyword(file_list, keyword)
        return file_list

